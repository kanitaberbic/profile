package ba.mozaik.projekat.User.Security;





import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * Centralni interfejs koji definiše osnovne korisničke informacije potrebne
 * za autentifikaciju i autorizaciju.
 */
public interface UserDetails extends Serializable {

    /**
     * Vraća kolekciju uloga i privilegija koje korisnik ima.
     *
     * @return Kolekcija objekata tipa {@link GrantedAuthority}.
     */
    Collection<? extends GrantedAuthority> getAuthorities();

    /**
     * Vraća lozinku korisnika.
     *
     * @return Lozinka (može biti hashovana).
     */
    String getPassword();

    /**
     * Vraća korisničko ime koje koristi za autentifikaciju.
     *
     * @return Korisničko ime.
     */
    String getUsername();

    /**
     * Označava da li korisnički nalog nije istekao.
     *
     * @return `true` ako nalog nije istekao, inače `false`.
     */
    boolean isAccountNonExpired();

    /**
     * Označava da li korisnički nalog nije zaključan.
     *
     * @return `true` ako nalog nije zaključan, inače `false`.
     */
    boolean isAccountNonLocked();

    /**
     * Označava da li korisničke akreditive (lozinka) nisu istekle.
     *
     * @return `true` ako akreditive nisu istekle, inače `false`.
     */
    boolean isCredentialsNonExpired();

    /**
     * Označava da li je korisnik trenutno aktivan.
     *
     * @return `true` ako je korisnik aktivan, inače `false`.
     */
    boolean isEnabled();
}
