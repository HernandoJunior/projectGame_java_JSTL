package br.com.fiap.jstl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/produto")
public class ProdutoServlet extends HttpServlet {
    private static List<Produto> lista = new ArrayList<Produto>();

    @Serial
	private static final long serialVersionUID = 1L;

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//Recupera os par?metros do formul?rio
    	String nome = request.getParameter("nome");
    	int qtd = Integer.parseInt(request.getParameter("quantidade"));
    	double valor = Double.parseDouble(request.getParameter("valor"));

    	//Cria um objeto do tipo Produtp
    	Produto produto = new Produto(nome, qtd, valor);

    	//Adiciona o produto na lista
    	lista.add(produto);

    	//Mensagem de sucesso
    	request.setAttribute("msg","Produto cadastrado!");
    	request.getRequestDispatcher("cadastrar-game.jsp").forward(request, response);

		
    }
}