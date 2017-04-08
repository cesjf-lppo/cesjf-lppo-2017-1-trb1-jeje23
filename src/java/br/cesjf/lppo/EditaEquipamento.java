
package br.cesjf.lppo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EditaEquipamento", urlPatterns = {"/edita.html"})
public class EditaEquipamento extends HttpServlet {


    
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Equipamento equipamento = new Equipamento();
       Long id = Long.parseLong(request.getParameter("id"));
        
        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527//lppo-2017-1", "usuario", "senha");
             
             Statement operacao = conexao.createStatement();
             ResultSet resultado = operacao.executeQuery("SELECT * FROM equipamento WHERE id=" +id);
                if(resultado.next()){
                    equipamento.setId(resultado.getLong("id"));
                    equipamento.setLocal(resultado.getString("local"));
                    equipamento.setEstado(resultado.getInt("estado"));       
                }
             
             
             
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaEquipamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaEquipamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("equipamento", equipamento);
        request.getRequestDispatcher("WEB-INF/edita-equipamento.jsp").forward(request, response);
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          Equipamento equipamento = new Equipamento();
          equipamento.setId( Long.parseLong(request.getParameter("id")));
          equipamento.setLocal(request.getParameter("local"));
          equipamento.setEstado(Integer.parseInt(request.getParameter("estado")));

        
        try {
      
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527//lppo-2017-1", "usuario", "senha");
             
             Statement operacao = conexao.createStatement();
             operacao.executeUpdate("UPDATE equipamento SET local= '"
                     +equipamento.getLocal()+ "', estado="
                     +equipamento.getEstado()+" WHERE id ="
                     +equipamento.getId() );
                
             
             
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaEquipamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaEquipamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("lista.html");
    
    }

    

}
