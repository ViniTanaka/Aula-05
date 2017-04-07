package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Funcionario;
import javax.swing.JOptionPane;

public class FuncionarioDAO_new {

    private Connection con;
    private Funcionario funcionario;

    public boolean inserirFuncionario(Funcionario funcionario) {
        boolean foiInserido = false;
        String sqlInsert = "INSERT INTO FUNCIONARIO(CPF,NOME, NASCIMENTO, HORARIOENTRADA, HORARIOSAIDA, RAZAO_SOCIAL) "
                + "VALUES (?,?,?,?,?,?)";
        try (Connection conn = ConnectionFactory.obtemConexao()) {
            PreparedStatement stmt = con.prepareStatement(sqlInsert);

            stmt.setString(1, funcionario.getCpf());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getNascimento());
            stmt.setString(4, funcionario.getHorarioEntrada());
            stmt.setString(5, funcionario.getHorarioSaida());
            stmt.setString(6, funcionario.getEmpresa());

            stmt.execute();//Executa o INSERT
            String sqlQuery = "SELECT LAST_INSERT_ID()";
            foiInserido = true;

//Caso tivermos um id gerado pelo banco é necessário resgatá-lo e setar no objeto            
//            try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
//                    ResultSet rs = stm2.executeQuery();) {
//                if (rs.next()) {
//                    funcionario.setID(rs.getInt(1));
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

//            stmt.close();//Fecha Statement
        } catch (SQLException e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception u) {
            JOptionPane.showMessageDialog(null, u.getMessage());
        }
        return foiInserido;
    }

    public Funcionario consultarFuncionario(Funcionario funcionario) {
        String sql = "SELECT * FROM Funcionario WHERE CPF = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getCpf());
            ResultSet r = stmt.executeQuery();
            while (r.next()) {
                funcionario.setCpf(r.getString(1));
                funcionario.setNome(r.getString(2));
                funcionario.setNascimento(r.getString(3));
                funcionario.setHorarioEntrada(r.getString(4));
                funcionario.setHorarioSaida(r.getString(5));
                funcionario.setEmpresa1(r.getString(6));
            }
            stmt.close();
        } catch (Exception u) {
            JOptionPane.showMessageDialog(null, u.getMessage());
        }

        return funcionario;
    }

    public void alterarFuncionario(Funcionario funcionario) {
        String sql = "UPDATE Funcionario SET Nome = ?, Nascimento = ?,"
                + " HorarioEntrada = ?, HorarioSaida = ?, RAZAO_SOCIAL = ? "
                + "WHERE CPF = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(6, funcionario.getCpf());
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getNascimento());
            stmt.setString(3, funcionario.getHorarioEntrada());
            stmt.setString(4, funcionario.getHorarioSaida());
            stmt.setString(5, funcionario.getEmpresa());
            stmt.execute();
            stmt.close();
        } catch (Exception u) {
            JOptionPane.showMessageDialog(null, u.getMessage());
        }
    }

    public void deletarFuncionario(Funcionario funcionario) {
        String sql = "DELETE FROM Funcionario WHERE CPF = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getCpf());
            stmt.execute();
            stmt.close();
        } catch (Exception u) {
            JOptionPane.showMessageDialog(null, u.getMessage());
        }
    }

    public boolean consultarNomeEmpresa(Funcionario funcionario) {
        boolean teste = false;
        String sql = "SELECT * FROM Empresa WHERE RAZAO_SOCIAL = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getEmpresa());
            ResultSet r = stmt.executeQuery();

            while (r.next()) {
                funcionario.setEmpresa1(r.getString(2));
                teste = true;
                System.out.println(teste);
//				empresa.setConjunto(r.getString(3));
//				empresa.setEntrada(r.getString(4));
//				empresa.setSaida(r.getString(5));
            }
            stmt.close();
        } catch (Exception u) {
            JOptionPane.showMessageDialog(null, u.getMessage());
        }
        return teste;
    }
}
