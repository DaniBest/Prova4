package utfpr.ct.dainf.if62c.avaliacao;

import java.util.TimerTask;
import static java.lang.System.*;
import java.util.Date;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author Daniel
 */
public class Aviso extends TimerTask {
    
    protected final Compromisso compromisso;

    public Aviso(Compromisso compromisso) {
       this.compromisso = compromisso;
    }

    public Compromisso getCompromisso() {
        return compromisso;
    }

    @Override
    public void run() {
        Date atual = new Date();
        out.println(String.format("%s começa em %ds", compromisso.getDescricao(), ((compromisso.getData().getTime()-atual.getTime())/1000l)));
    }     
}
