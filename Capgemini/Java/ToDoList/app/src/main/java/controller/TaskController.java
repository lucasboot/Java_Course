/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author varel
 */
public class TaskController {
    public void save(Task task){
        String sql = "INSERT INTO tasks (idProject,"
                + "name,"
                + "description,"
                + "completed,"
                + "notes,"
                + "deadline ) VALUES (?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement statement = null;
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql); //preparar o comando para ser executado no BD
            statement.setInt(1, task.getIdProject()); //primeiro ? será substituido pelo valor taskId
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
         
        } catch (Exception e){
             throw new RuntimeException("Erro ao salvar tarefa " +e.getMessage(), e);
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
            
           
        }
        
    }
    public void update(Task task){
        String sql = "UPDATE  tasks SET"
                + "idProject = ?,"
                + "name = ?,"
                + "description = ?,"
                + "completed = ?,"
                + "notes = ?,"
                + "deadline = ? "
                + "createdAt = ?,"
                + "updatedAt = ?"
                + "WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            //estabelecendo a conexão com o BD
            conn = ConnectionFactory.getConnection();
            //criando e preparando o statement em SQL
            statement = conn.prepareStatement(sql);
            //substituindo as ? por dados da tarefa a ser atualizada
            statement.setInt(1, task.getIdProject()); 
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            //executando o statement
            statement.execute();
        } catch(Exception e){
            throw new RuntimeException("Erro ao atualizar a tarefa");
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    public void removeById(int taskId){
        String sql = "DELETE FROM tasks WHERE id = ?"; //substituir a ? pelo id
        Connection conn = null;
        PreparedStatement statement = null;
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql); //preparar o comando para ser executado no BD
            statement.setInt(1, taskId); //primeiro ? será substituido pelo valor taskId
            statement.execute();
        } catch (Exception e){
            throw new RuntimeException("Erro ao deletar tarefa");
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    public List<Task> getAll(int idProject){
        String sql = "SELECT * FROM tasks WHERE idProject=? ";
        Connection conn = null;
        PreparedStatement statement = null;
        //set de resultado do SELECT SQL para extrair informações de cada tarefa
        ResultSet resultSet = null;
        
        //lista de tarefas do projeto
        List<Task> tasks = new ArrayList<Task>();
          try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql); 
            statement.setInt(1, idProject); 
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Task task = new Task();
                //povoando a task auxiliar com as informações da tarefa atual do resultSet
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                //adicionando a task na lista do projeto solicitado
                tasks.add(task);
            }
        } catch (Exception e){
            throw new RuntimeException("Erro ao pegar tarefas do projeto");
        } finally{
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        return tasks;
    }
}
