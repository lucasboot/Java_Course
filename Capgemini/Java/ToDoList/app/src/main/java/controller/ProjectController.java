/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author varel
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import model.Task;
import util.ConnectionFactory;

public class ProjectController {
    
    public void save(Project project){
        String sql = "INSERT INTO projects (name,description,createdAt,updatedAt)"
                + "VALUES (?,?,?,?)";
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            
            statement.execute();
        } catch(Exception e){
            throw new RuntimeException("Erro ao salvar projeto " +e.getMessage(), e);

        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    public void update(Project project){
        String sql = "UPDATE projects SET"
                + "name=?,"
                + "description=?,"
                + "createdAt=?,"
                + "updatedAt=? "
                + "WHERE id=?";
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());

            
            statement.execute();
        } catch(Exception e){
            throw new RuntimeException("Erro ao atualizar projeto " +e.getMessage(), e);

        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    public void removeById(int projectId){
        String sql = "DELETE FROM projects WHERE id=?";
        Connection conn = null;
        PreparedStatement statement = null;
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql); //preparar o comando para ser executado no BD
            statement.setInt(1, projectId); //primeiro ? será substituido pelo valor taskId
            statement.execute();
        } catch (Exception e){
            throw new RuntimeException("Erro ao deletar projeto");
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    public List<Project> getAll(){
            String sql = "SELECT * FROM projects";
            Connection conn = null;
            PreparedStatement statement = null;
            //set de resultado do SELECT SQL para extrair informações de cada tarefa
            ResultSet resultSet = null;

            //lista de tarefas do projeto
            List<Project> projects = new ArrayList<Project>();
              try{
                conn = ConnectionFactory.getConnection();
                statement = conn.prepareStatement(sql); 
                resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
                    Project project = new Project();
                    //povoando o project auxiliar com as informações do projeto atual do resultSet
                    project.setId(resultSet.getInt("id"));
                    project.setName(resultSet.getString("name"));
                    project.setDescription(resultSet.getString("description"));
                    project.setCreatedAt(resultSet.getDate("createdAt"));
                    project.setUpdatedAt(resultSet.getDate("updatedAt"));

                    //adicionando a task na lista do projeto solicitado
                    projects.add(project);
                }
            } catch (Exception e){
                throw new RuntimeException("Erro ao pegar os projetos");
            } finally{
                ConnectionFactory.closeConnection(conn, statement, resultSet);
            }
            return projects;
        }
        
    }

