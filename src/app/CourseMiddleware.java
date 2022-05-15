/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author joaov
 */
public class CourseMiddleware extends Middleware {
    private ClassServidor servidor;
    private String curso;

    public CourseMiddleware(ClassServidor servidor, String curso) {
        this.servidor = servidor;
        this.curso = curso;
    }
    
    @Override
    public boolean check(String nome, String senha, String cod) {
        boolean aux = checkFree();
        if(!aux){
            if(servidor.getUsuariosPagantes().get(nome) != null){
                if(!checkPrata(nome)){
                    if(!checkOuro(nome)){
                        System.out.println("Eleve seu plano para acessar o curso: " + this.curso);
                        return checkNext(nome, senha, cod);
                    }
                }
            }else if(servidor.getUsuariosPagantes().get(nome) != null || !aux){
                System.out.println("Eleve seu plano para acessar o curso: " + this.curso);
            }
        }
        return false;
    }
    public boolean checkFree(){
        if(servidor.getCursosOferecidos().get(curso).equals("Free")){
            System.out.println("Curso: " + curso + " liberado com sucesso");
            return true;
        }  
        return false;
    }
    public boolean checkPrata(String nome){
        if(servidor.getUsuariosPagantes().get(nome).equals("Prata")){
            if(servidor.getCursosOferecidos().get(curso).equals("Prata")){
                System.out.println("Curso: " + curso + " liberado com sucesso");
                return true;
            }
        }
        return false;
    }
    public boolean checkOuro(String nome){
        if(servidor.getUsuariosPagantes().get(nome).equals("Ouro")){
            if(servidor.getCursosOferecidos().get(curso).equals("Ouro")){
                System.out.println("Curso: " + curso + " liberado com sucesso");
                return true;
            }
        }
        return false;
    }
}
