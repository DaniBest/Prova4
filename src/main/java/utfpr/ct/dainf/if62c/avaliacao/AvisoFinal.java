package utfpr.ct.dainf.if62c.avaliacao;

import static java.lang.System.*;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author Daniel
 */
public class AvisoFinal extends Aviso {

    public AvisoFinal(Compromisso compromisso) {
        super(compromisso);
    }
    
    @Override
    public void run() {
        for(Aviso aviso:compromisso.getAvisos()) {
            aviso.cancel();
        }
        out.println(String.format("%s começa agora", compromisso.getDescricao()));
    }
    
}
