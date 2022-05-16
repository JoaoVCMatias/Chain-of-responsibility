/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author joaov
 */
public class ClassServidor {
    private Map<String, String> usuarios = new HashMap<>(); //Nome e senha(para a validação do usuario)
    private Map<String, String> usuariosPagantes = new HashMap<>(); //Nome e valor pago dos usuarios pagantes
    private Map<String, String> cursosOferecidos = new HashMap<>();
    private Middleware middleware;
    
    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }
    
    public boolean logIn(String nome, String senha, String cod) {
        if (middleware.check(nome, senha, cod)) { //Função que vai analisar se o usuario é valido em UserExistsMiddleware
            System.out.println("Usuario valido");
            return true;
        }
        return false;
    }
    
    public boolean checkCursos(String nome, String senha, String cod){ //CheckCursos chama o check do CourseExistsMiddleware
        if (middleware.check(nome, senha, cod)) {
            return true;
        }
        return false;
    }
    
    public void cursosOferecidosM(){
        this.cursosOferecidos.put("Filosofia", "Free");
        this.cursosOferecidos.put("Artes", "Free");
        this.cursosOferecidos.put("Matematica", "Prata");
        this.cursosOferecidos.put("Portugues", "Prata");
        this.cursosOferecidos.put("Historia", "Prata");
        this.cursosOferecidos.put("Ingles", "Ouro");
        this.cursosOferecidos.put("Quimica", "Ouro");
        this.cursosOferecidos.put("Redacao", "Ouro");
        this.cursosOferecidos.put("Fisica", "Ouro");
        
    }
    
    public ClassServidor() {
        usuarios.put("Joao", "123");
        usuarios.put("Maria", "456");
        usuarios.put("Pedro", "789");
        inserirPlanoPrata("Maria");
        inserirPlanoOuro("Pedro");
        cursosOferecidosM();
    }
    
    public void inserirPlanoPrata(String nome){
        this.usuariosPagantes.put(nome, "Prata");
    }
    
    public void inserirPlanoOuro(String nome){
        this.usuariosPagantes.put(nome, "Ouro");
    }
    
    public void novoUsuario(String nome, String senha, String plano){
        usuarios.put(nome, senha);
        if(plano.equals("Prata")){
            inserirPlanoPrata(nome);
        }
        if(plano.equals("Ouro")){
            inserirPlanoOuro("nome");
        }
    }
    
    public Boolean possuiNome(String nome){
        return usuarios.containsKey(nome);
    }
    public String planoUsuario(String nome){
        return usuariosPagantes.get(nome);
    }
    public Boolean usuarioValido(String nome, String senha){ //Valida usuario (chave/valor)
        return usuarios.get(nome).equals(senha);
    }
    public void getUsuarios(){
        System.out.println(usuarios);
                
    }

    public Map<String, String> getUsuariosPagantes() {
        return usuariosPagantes;
    }
    

    public Map<String, String> getCursosOferecidos() {
        return cursosOferecidos;
    }
    
    
    
    
    
    
    
    
}
