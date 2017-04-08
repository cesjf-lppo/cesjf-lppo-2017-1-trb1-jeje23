<%-- 
    Document   : edita-equipamento
    Created on : 04/04/2017, 23:50:13
    Author     : Jessica Barbosa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edita Equipamento</title>
    </head>
    <body>
         <h1>Edita Equipamento</h1>
        <form method="post">
            <div><input type="hidden" name="id" value="${equipamento.id}"/> Id: ${equipamento.id}</div>
            <div><label>Local <input type="text" name="local" value="${equipamento.local}"/></label></div>
            Estado: <select name="estado" >
                    <option></option>
                    <option value="0" ${equipamento.estado==0?"selected":""}>Novo</option>
                    <option value="1" ${equipamento.estado==1?"selected":""}>Em uso</option>
                    <option value="2" ${equipamento.estado==2?"selected":""}>Danificado</option>
                    <option value="3" ${equipamento.estado==3?"selected":""}>Perdido</option>
                </select><br><br>
                
            
            <div><input type="submit" /></div>
    </body>
</html>
