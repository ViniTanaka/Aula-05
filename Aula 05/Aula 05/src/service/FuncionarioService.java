package service;

import dao.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioService {

    FuncionarioDAO dao = new FuncionarioDAO();

    public boolean criar(Funcionario funcionario) {
        return dao.inserirFuncionario(funcionario);
    }

    public void atualizar(Funcionario funcionario) {
        dao.alterarFuncionario(funcionario);
    }

    public void excluir(Funcionario funcionario) {
        dao.deletarFuncionario(funcionario);
    }

    //fazer o método carregar importar todos os dados do banco
    //e inserir em um objeto de funcionário e retornar
    //public Funcionario carregar(String cpf){
    public Funcionario carregar(Funcionario funcionario) {
        return dao.consultarFuncionario(funcionario);
        
    }
}
