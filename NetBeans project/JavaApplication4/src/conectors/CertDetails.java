/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectors;

import beans.CertDetailTransporter;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.X509Certificate;
import keystores.*;
import org.bouncycastle.asn1.x500.X500Name;

/**
 *
 * @author User
 */
public class CertDetails {

    KeyStore ks = null;
    CertDetailTransporter details = null;

    public CertDetails(String alias) {
        getIstance(alias);
    }

    private boolean getIstance(String alias) {
        ks = LocalSignedCertKeyStore.getIstance();

        try {
            X509Certificate cert = (X509Certificate) ks.getCertificate(alias);
            if (cert == null) {
                return false;
            }

            details.setSigner(new X500Name(cert.getSigAlgName()));
            details.setIssuer(new X500Name(cert.getIssuerX500Principal()
                    .getName()));
            details.setSubject(new X500Name(cert.getSubjectX500Principal()
                    .getName()));

            details.setValidFrom(cert.getNotBefore());
            details.setValidTo(cert.getNotBefore());

            details.setPubKey(cert.getPublicKey());
            details.setVersion(cert.getVersion());

            details.setCriticalExt(cert.getCriticalExtensionOIDs());
            details.setNonCriticalExt(cert.getNonCriticalExtensionOIDs());

            details.setSerialNum(cert.getSerialNumber());
            details.setSigAlg(cert.getSigAlgOID());

        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return true;
    }

    public CertDetailTransporter getDetails(String alias) {
        return details;
    }

    public String toString() {

        String cert = "";

        cert += "Certificate:/n/tData:/n/t/tVersion: "
                + details.getVersion()
                + "/n/t/tSerial Number: "
                + details.getSerialNum()
                + "/n/t/tSigniture Algorithm: "
                + details.getSigAlg()
                + "/n/t/tIssuer: "
                + details.getIssuer()
                + "/n/t/tValidity: /n/t/t/tNot Before: "
                + details.getValidFrom()
                + "/n/t/t/tNot After: "
                + details.getValidTo()
                + "/n/t/tSubject: "
                + details.getSubject()
                + "/n/t/tSubject Public Key Info:/n/t/t/tPublic Key Algorithm: "
                + details.getPubKeyAlg() + "/n/t/t/tRSA Public Key: /n"
                + details.getPubKey() + "/nCritical Extensions: "
                + details.getCriticalExt() + "/nNonCritical Extensions: "
                + details.getNonCriticalExt() + "/nSigniture:/n"
                + details.getSigner();

        return cert;
    }

    public static String toString(String alias) {

        KeyStore ks = LocalSignedCertKeyStore.getIstance();
        X509Certificate cert = null;
        try {
            cert = (X509Certificate) ks.getCertificate(alias);
            if (cert == null) {
                return "EROR: NO CERTIFICATE FOUND!";
            }

        } catch (Exception e) {
        }
        return cert.toString();
    }
}
