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
public class Lance {
    private final Participante participante; 
    private final Double preco; 
    
    public Lance(Participante participante, Double preco){
        this.participante = participante; 
        this.preco = preco; 
    }

    public Participante getParticipante() {
        return participante;
    }

    public Double getPreco() {
        return preco;
    }
    
    
}
