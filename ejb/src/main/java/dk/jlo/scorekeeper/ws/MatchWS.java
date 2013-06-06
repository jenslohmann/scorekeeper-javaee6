package dk.jlo.scorekeeper.ws;

import dk.jlo.scorekeeper.ctrl.MatchCtrl;
import dk.jlo.scorekeeper.model.Match;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@WebService(serviceName = "MatchWS")
public class MatchWS {
    @EJB
    MatchCtrl matchCtrl;

    @WebMethod
    public String createMatch() {
        matchCtrl.register(new Match());
        return "";
    }
}
