/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author aluno
 */
@WebServlet(name = "ListaEquipamentoFiltroServlet", urlPatterns = {"/lista-filtro.html"})
public class ListaEquipamentoFiltroServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
        int filtroDoEstado;
        
        if (request.getParameter("filtro")==null) {
            filtroDoEstado = -1;
        } else {
            filtroDoEstado = Integer.parseInt(request.getParameter("filtro"));
        }
        
        List<Equipamento> equipamentos = new ArrayList<>();
        
        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527//lppo-2017-1", "usuario", "senha");
             
             Statement operacao = conexao.createStatement();
             ResultSet resultado;
            if (filtroDoEstado==-1) {
                resultado = operacao.executeQuery("SELECT * FROM equipamento ORDER BY local");
            } else {
                resultado = operacao.executeQuery("SELECT * FROM equipamento WHERE estado = " + filtroDoEstado + " ORDER BY local");
            }
                while(resultado.next()){
                    Equipamento novoEquipamento = new Equipamento();
                    novoEquipamento.setId(resultado.getLong("id"));
                    novoEquipamento.setSerie(resultado.getString("serie"));
                    novoEquipamento.setLocal(resultado.getString("local"));
                    novoEquipamento.setDescricao(resultado.getString("descricao"));
                    novoEquipamento.setEstado(resultado.getInt("estado"));
                    equipamentos.add(novoEquipamento);
                }        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaEquipamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaEquipamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("equipamentos", equipamentos);
        request.getRequestDispatcher("WEB-INF/lista-filtro.jsp").forward(request, response);
       
    }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
   

}
