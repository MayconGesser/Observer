/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 *
 * @author cuntycunt
 */
public interface Subject {
    public void notificarInscritos();
    
    //metodo sobrecarregado jah q Java nao tem argumentos default...
    public void notificarInscritos(Object mensagem);
    public void aceitarInscricao(Observer obs);
}
