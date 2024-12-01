package ba.mozaik.projekat.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommmentRepository extends JpaRepository<Comment ,Long> {

}
