/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author joaov
 */
public class CourseExistsMiddleware extends Middleware {
    private String cursoTela;
    private ClassServidor servidor;
    
    public CourseExistsMiddleware() {}
    
    public CourseExistsMiddleware(String cursoTela, ClassServidor servidor) {
        this.cursoTela = cursoTela;
        this.servidor = servidor;
    }
    
    @Override
    public boolean check(String nome, String senha, String cod) {
        if(this.servidor.getCursosOferecidos().containsKey(this.cursoTela)){
            return checkNext(nome, senha, cod);
        }
        System.out.println("O curso: " + this.cursoTela +" não está sendo oferecido no momento, ou foi escrito de forma incorreta");
        return false;
    }

    public void setCursoTela(String cursoTela) {
        this.cursoTela = cursoTela;
    }
    

    
}
