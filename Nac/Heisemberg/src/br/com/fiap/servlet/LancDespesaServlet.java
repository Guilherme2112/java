package br.com.fiap.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.flow.SwitchFlowContext;

import br.com.fiap.Excecao.Excecoes;
import br.com.fiap.beans.Despesa;
import br.com.fiap.beans.LancaDespesa;
import br.com.fiap.beans.Processo;
import br.com.fiap.bo.DespBO;
import br.com.fiap.bo.LancDespBO;
import br.com.fiap.conexao.Conexao;

@WebServlet("/LancDespServlet")
public class LancDespesaServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection conexao = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int procNum = 0;
		int cdLancamento = 0;
		String data = null;
		double vlHora = 0;
		String observacao = null;
		Despesa desp = null;
		int numProc = Integer.parseInt(req.getParameter("numProc"));
		String acao = req.getParameter("acao");
		String msg = null;
		LancaDespesa objLancaDesp = null;
		List<LancaDespesa> despesas = null;
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
				despesas = LancDespBO.l(conexao, numProc);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			req.setAttribute("numProc", numProc);
			req.setAttribute("desps", despesas);
			req.getRequestDispatcher("ListaDespesa.jsp").forward(req, resp);
			break;

		case "excluir":
			cdLancamento = Integer.parseInt(req.getParameter("cdLancamento"));
			numProc = Integer.parseInt(req.getParameter("numProc"));

			try {
				LancDespBO.d(cdLancamento, conexao);
				despesas = LancDespBO.l(conexao, numProc);
			} catch (Exception e) {
				new Excecoes(e);
				req.setAttribute(msg, "Ocorreu um erro");
			}

			req.setAttribute("desps", despesas);
			req.setAttribute("msg", "Sucesso!");
			req.getRequestDispatcher("ListaDespesa.jsp").forward(req, resp);

			break;
		case "cadastrar":
			numProc = Integer.parseInt(req.getParameter("numProc"));
			List<Despesa> tipoDesp = null;
			try {
				tipoDesp = DespBO.l(conexao);
				{

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("numProc", numProc);
			req.setAttribute("tiposDespesa", tipoDesp);
			req.getRequestDispatcher("LancaDespesa.jsp").forward(req, resp);
			break;

		case "editar":
			cdLancamento = Integer.parseInt(req.getParameter("cdLancamento"));
			numProc = Integer.parseInt(req.getParameter("numProc"));
			LancaDespesa despesa = null;
			List<Despesa> tiposDespesa = null;
			try {
				despesa = LancDespBO.r(cdLancamento, conexao);
				tiposDespesa = DespBO.l(conexao);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("numProc", numProc);
			req.setAttribute("tiposDespesa", tiposDespesa);
			req.setAttribute("desp", despesa);
			req.getRequestDispatcher("EditaDespesa.jsp").forward(req, resp);

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
			Despesa d = new Despesa(Integer.parseInt(req.getParameter("despesa")));
			String data = req.getParameter("data");
			double vlHora = Double.parseDouble(req.getParameter("vlHora"));
			String observacao = req.getParameter("observacao");
			int numProc = Integer.parseInt(req.getParameter("numProc"));

			Processo p = new Processo(numProc);
			LancaDespesa lcd = new LancaDespesa(p, data, vlHora, observacao, 0, d);
			List<LancaDespesa> despesas = null;
			String msg = null;

			try {
				LancDespBO.c(lcd, conexao);
				msg = "Sucesso!";
			} catch (Exception e) {
				msg = "Erro ao lançar despesa.";
				new Excecoes("Falha ao realizar operação");
				e.printStackTrace();

			}
			try {
				despesas = LancDespBO.l(conexao, numProc);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			req.setAttribute("desps", despesas);
			req.setAttribute("numProc", numProc);
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("ListaDespesa.jsp").forward(req, resp);
			break;
		case "aplicar":
			List<LancaDespesa> listDesps = null;
			d = new Despesa(Integer.parseInt(req.getParameter("despesa")));
			data = req.getParameter("data");
			vlHora = Double.parseDouble(req.getParameter("vlHora"));
			observacao = req.getParameter("observacao");
			numProc = Integer.parseInt(req.getParameter("numProc"));
			p = new Processo(numProc);
			cdLancamento = Integer.parseInt(req.getParameter("cdLancamento"));
			lcd = new LancaDespesa(p, data, vlHora, observacao, cdLancamento, d);

			try {
				LancDespBO.u(lcd, conexao);
				listDesps = LancDespBO.l(conexao, numProc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("cdLancamento", cdLancamento);
			req.setAttribute("numProc", numProc);
			req.setAttribute("desps", listDesps);
			req.getRequestDispatcher("ListaDespesa.jsp").forward(req, resp);
		default:
			break;
		}

	}

}
