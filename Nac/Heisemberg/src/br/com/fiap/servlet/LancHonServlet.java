package br.com.fiap.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.Excecao.Excecoes;
import br.com.fiap.beans.Honorario;
import br.com.fiap.beans.LancaDespesa;
import br.com.fiap.beans.LancaHonorario;
import br.com.fiap.beans.Processo;
import br.com.fiap.bo.HonBO;
import br.com.fiap.bo.LancDespBO;
import br.com.fiap.bo.LancHonBO;
import br.com.fiap.conexao.Conexao;

@WebServlet("/LancHonServlet")
public class LancHonServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection conexao = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cdLancamento = 0;
		String data = null;
		double qtHora = 0;
		String observacao = null;
		Honorario hono = null;
		int numProc = Integer.parseInt(req.getParameter("numProc"));
		String acao = req.getParameter("acao");
		String msg = null;
		List<LancaHonorario> honos = null;
		try {

			conexao = new Conexao().getConnection("OPS$RM76824", "270298");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch (acao) {
		case "listar":
			numProc = Integer.parseInt(req.getParameter("numProc"));
			try {
				honos = LancHonBO.l(conexao,numProc);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			req.setAttribute("numProc", numProc);
			req.setAttribute("honos", honos);
			req.getRequestDispatcher("ListaHonorario.jsp").forward(req, resp);
			break;

		case "excluir":
			cdLancamento = Integer.parseInt(req.getParameter("cdLancamento"));
			numProc = Integer.parseInt(req.getParameter("numProc"));

			try {
				LancHonBO.d(cdLancamento, conexao);
				honos = LancHonBO.l(conexao,numProc);
			} catch (Exception e) {
				new Excecoes(e);
				req.setAttribute(msg, "Ocorreu um erro");
			}

			req.setAttribute("honos", honos);
			req.setAttribute("msg", "Sucesso!");
			req.getRequestDispatcher("ListaHonorario.jsp").forward(req, resp);

			break;
		case "cadastrar":
			numProc = Integer.parseInt(req.getParameter("numProc"));
			List<Honorario> tipoHono = null;
			try {
				tipoHono = HonBO.l(conexao);
				{

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("numProc", numProc);
			req.setAttribute("tiposHonorario", tipoHono);
			req.getRequestDispatcher("LancaHonorario.jsp").forward(req, resp);
			break;

		case "editar":
			cdLancamento = Integer.parseInt(req.getParameter("cdLancamento"));
			numProc = Integer.parseInt(req.getParameter("numProc"));
			LancaHonorario honorario = null;
			List<Honorario> tiposHonorario = null;
			try {
				honorario = LancHonBO.r(cdLancamento, conexao);
				tiposHonorario = HonBO.l(conexao);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("numProc", numProc);
			req.setAttribute("tiposHonorario", tiposHonorario);
			req.setAttribute("hono", honorario);
			req.getRequestDispatcher("EditaHonorario.jsp").forward(req, resp);

			break;
		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			conexao = new Conexao().getConnection("OPS$RM76824", "270298");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String acao = req.getParameter("acao");
		int cdLancamento = 0;

		switch (acao) {
		case "lancar":
			Honorario h = new Honorario(Integer.parseInt(req.getParameter("honorario")));
			String data = req.getParameter("data");
			double qtHora = Double.parseDouble(req.getParameter("qtHora"));
			String observacao = req.getParameter("observacao");
			int numProc = Integer.parseInt(req.getParameter("numProc"));

			Processo p = new Processo(numProc);
			LancaHonorario lch = new LancaHonorario(p, data, qtHora, observacao, 0, h);
			List<LancaHonorario> honorarios = null;
			String msg = null;

			try {
				LancHonBO.c(lch, conexao);
				msg = "Sucesso!";
			} catch (Exception e) {
				msg = "Erro ao lançar despesa.";
				new Excecoes("Falha ao realizar operação");
				e.printStackTrace();

			}
			try {
				honorarios = LancHonBO.l(conexao, numProc);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			req.setAttribute("honos", honorarios);
			req.setAttribute("numProc", numProc);
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("ListaHonorario.jsp").forward(req, resp);
			break;
		case "aplicar":
			List<LancaHonorario> listHonos = null;
			h = new Honorario(Integer.parseInt(req.getParameter("honorario")));
			data = req.getParameter("data");
			qtHora = Double.parseDouble(req.getParameter("qtHora"));
			observacao = req.getParameter("observacao");
			numProc = Integer.parseInt(req.getParameter("numProc"));
			p = new Processo(numProc);
			cdLancamento = Integer.parseInt(req.getParameter("cdLancamento"));
			lch = new LancaHonorario(p, data, qtHora, observacao, cdLancamento, h);

			try {
				LancHonBO.u(lch, conexao);
				listHonos = LancHonBO.l(conexao,numProc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("cdLancamento", cdLancamento);
			req.setAttribute("numProc", numProc);
			req.setAttribute("honos", listHonos);
			req.getRequestDispatcher("ListaHonorario.jsp").forward(req, resp);
		default:
			break;
		}

	}

}
