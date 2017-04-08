<%-- 
    Document   : lista-filtro
    Created on : 06/04/2017, 00:57:28
    Author     : Jessica Barbosa
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Registros por Filtro</title>
    </head>
    <body>
        <h1>Lista de Registros por Filtro</h1>
            <form>
                <select name="filtro">
                    <option value="0">Novo</option>
                    <option value="1">Em Uso</option>
                    <option value="2">Danificado</option>
                    <option value="3">Perdido</option>
                </select>
                    <button type="submit">Filtrar</button>
            </form>
              <br />
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
                    <td><a href="edita.html?id=${equipamento.id}">${equipamento.id}</a></td>
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
                    <a href="lista.html">Lista Equipamento</a>
         </div> 
    </body>
</html>
