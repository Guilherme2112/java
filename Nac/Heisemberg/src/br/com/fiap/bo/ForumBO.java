package br.com.fiap.bo;

import br.com.fiap.beans.Forum;
import br.com.fiap.dao.ForumDAO;

public abstract class ForumBO {
	static void c(Forum forum) throws Exception {
		ForumDAO.c(forum);
	}

	static void r(String search) {
		ForumDAO.r(search);
	}
	static void u(String n){
		ForumDAO.u(n);
	}
	static void d(String n){
		ForumDAO.d(n);
	}

}
