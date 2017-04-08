<%-- 
    Document   : lista-equipamento
    Created on : 03/04/2017, 22:11:49
    Author     : aluno
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Equipamento</title>
    </head>
    <body>
        <h1>Lista de Equipamento</h1>
        <table border="1">
            
            <tr>
                <th>Id</th>
                <th>Numero de Serie</th>
                <th>Local</th>
                <th>Descrição</th>
                <th>Estado</th>
                <th>Excluir</th>
                
            </tr>
            <c:forEach var="equipamento" items="${equipamentos}">
                <tr>
                    
                <td><a href="edita.html?id=${equipamento.id}"> ${equipamento.id} </a></td>   
                <td>${equipamento.serie}</td> 
                <td>${equipamento.local}</td> 
                <td>${equipamento.descricao}</td> 
                  
                    
                    <td>
                         <c:if test="${equipamento.estado==0}">
                        Novo
                    </c:if>
                    <c:if test="${equipamento.estado==1}">
                        Em Uso
                    </c:if>
                     <c:if test="${equipamento.estado==2}">
                        Danificado
                    </c:if>
                    <c:if test="${equipamento.estado==3}">
                       Perdido 
                    </c:if>
                </td>
                <td><a href="exclui.html?id=${equipamento.id}">X</a></td>
                
                    
                </tr>
            </c:forEach>
                <div>
                    <a href="novo.html">Registrar novo equipamento</a>
                    <a href="lista-filtro.html">Lista por Filtro</a>
                </div> 
    </body>
</html>
