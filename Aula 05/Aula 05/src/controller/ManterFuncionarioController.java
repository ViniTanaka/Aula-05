package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Funcionario;
import service.FuncionarioService;

/**
 * Servlet implementation class ManterFuncionarioController
 */
@WebServlet("/ManterFuncionario.do")
public class ManterFuncionarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pEmpresa = request.getParameter("empresa");
        String pNome = request.getParameter("nome");
        String pCpf = request.getParameter("cpf");
        String pNascimento = request.getParameter("nascimento");
        String pHorarioEntrada = request.getParameter("horarioEntrada");
        String pHorarioSaida = request.getParameter("horarioSaida");
        
        //instanciar o javabean
        Funcionario funcionario = new Funcionario();
        funcionario.setEmpresa1(pEmpresa);
        funcionario.setNome(pNome);
        funcionario.setCpf(pCpf);
        funcionario.setNascimento(pNascimento);
        funcionario.setHorarioEntrada(pHorarioEntrada);
        funcionario.setHorarioSaida(pHorarioSaida);
//        funcionario.setEmpresa1("1");
//        funcionario.setNome("1");
//        funcionario.setCpf("2");
//        funcionario.setNascimento("1");
//        funcionario.setHorarioEntrada("1");
//        funcionario.setHorarioSaida("1");
        
        //instanciar o service
        FuncionarioService cs = new FuncionarioService();
        cs.criar(funcionario);
        //funcionario = cs.carregar(funcionario);
        
        //enviar para o jsp
        request.setAttribute("funcionario", funcionario);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Funcionario.jsp");
        view.forward(request, response);
        
    }
    
}
