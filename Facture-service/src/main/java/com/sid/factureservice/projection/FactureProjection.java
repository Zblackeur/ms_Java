package com.sid.factureservice.projection;

import com.sid.factureservice.model.Facture;
import com.sid.factureservice.model.FactureLigne;
import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name = "fullFacture", types= Facture.class)
public interface FactureProjection {

    public Long getId();

    public Date getDateFacture();


    public Long getClientID();

    public Collection<FactureLigne> getFactureLignes();


}
