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
public class Observer {
    
    protected Object ultimaMensagemRecebida;
    
    public void receberNotificacao(Object mensagem){
        this.ultimaMensagemRecebida = mensagem; 
    }
}
