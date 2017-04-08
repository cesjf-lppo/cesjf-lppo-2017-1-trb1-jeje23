<%-- 
    Document   : novo-equipamento
    Created on : 03/04/2017, 21:34:06
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Equipamento</title>
    </head>
    <body>
          <h1>Novo Equipamento</h1>
        <form method="post">
            <label> Numero de Serie:
                <input type="text" name="serie" />
            </label>
            <label> Local:
                <input type="text" name="local"  />
            </label>
            <label> Descricao:
                <textarea name="descricao"></textarea>
            </label>
            <label>
            Status: <select name="estado" >
                    <option></option>
                    <option value="0">Novo</option>
                    <option value="1">Em Uso </option>
                    <option value="2">Danificado</option>
                    <option value="3">Perdido</option>
                </select><br><br>
            </label>
            
            <input type="submit"/>
            <div>
                    <a href="lista.html">Lista Equipamento</a>
                    <a href="lista-filtro.html">Lista por Filtro</a>
                </div> 
        </body>
</html>
