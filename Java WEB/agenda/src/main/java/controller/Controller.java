package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();
	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		}else if (action.equals("/delete")) {
			removerContato(request, response);
		}else {
			response.sendRedirect("index.html");
		}
		/*
		 * Teste dao.testeConexao();
		 */
	}

	// listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//Criar um objeto pra receber o JavaBeans
			ArrayList<JavaBeans> lista = dao.listarContatos();
			//teste de recebimento
			/*
			for (int i=0; i<lista.size(); i++) {
				System.out.println(lista.get(i).getIdcon());
				System.out.println(lista.get(i).getNome());
				System.out.println(lista.get(i).getFone());
				System.out.println(lista.get(i).getEmail());

			}
			*/
			
			//Encaminhar a lista ao documento agenda.jsp
			request.setAttribute("contatos", lista);
			RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
			rd.forward(request, response);
	}
	
	// Adicionar contato
		protected void novoContato(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			//teste de recebimendo
			//System.out.println(request.getParameter("nome"));
			
			//Setting as variáveis
			contato.setNome(request.getParameter("nome"));
			contato.setFone(request.getParameter("fone"));
			contato.setEmail(request.getParameter("email"));
			
			//Invocar método do DAO
			dao.inserirContato(contato);
			
			//Redirecionar para o agenda.jsp
			response.sendRedirect("main");
			
		}
		//Editar contato
		protected void listarContato(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			//Receber o id do contato na linha do botão editar clicado
			String idcon = request.getParameter("idcon");
			//System.out.println(idcon);
			
			//Set variável JB
			contato.setIdcon(idcon);
			//Executar método DAO
			
			dao.selecionarContato(contato);
			//Dados do contato selecionado
			//System.out.println(contato.getIdcon());
			//System.out.println(contato.getNome());
			
			//Setar os atrib do formulário com o conteúdo JB
			request.setAttribute("idcon", contato.getIdcon());
			request.setAttribute("nome", contato.getNome());
			request.setAttribute("fone", contato.getFone());
			request.setAttribute("email", contato.getEmail());
			//Encaminhar ao documento editar.jsp
			RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
			rd.forward(request, response);

		}
		protected void editarContato(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{
			//setar variáveis JB
			contato.setIdcon(request.getParameter("idcon"));
			contato.setNome(request.getParameter("nome"));
			contato.setFone(request.getParameter("fone"));
			contato.setEmail(request.getParameter("email"));
			
			//executar método do DAO
			dao.alterarContato(contato);
			
			//Redirecionar para agenda.jsp com alterações
			response.sendRedirect("main");
		
		}
		//Remover um contato
		protected void removerContato(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{
			//Recebimento do id do contato a ser excluido
			String idcon = request.getParameter("idcon");
			//System.out.println(idcon);
			
			//Setar a variavel JB
			contato.setIdcon(idcon);
			
			//Deletar contato no banco de dados a partir da DAO
			dao.deletarContato(contato);
			
			//Redirecionar pro agenda.jsp
			response.sendRedirect("main");
		}
}
