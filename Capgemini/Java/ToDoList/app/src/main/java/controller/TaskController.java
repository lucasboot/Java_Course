/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            statement.setInt(1, task.getIdProject()); //primeiro ? ser� substituido pelo valor taskId
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
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, task.getIdProject()); 
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
        } catch(Exception e){
            throw new RuntimeException("Erro ao atualizar a tarefa");
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    public void removeById(int taskId) throws SQLException{
        String sql = "DELETE FROM tasks WHERE id = ?"; //substituir a ? pelo id
        Connection conn = null;
        PreparedStatement statement = null;
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql); //preparar o comando para ser executado no BD
            statement.setInt(1, taskId); //primeiro ? ser� substituido pelo valor taskId
            statement.execute();
        } catch (Exception e){
            throw new RuntimeException("Erro ao deletar tarefa");
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    public List<Task> getAll(int idProject){
        return null;
    }
}