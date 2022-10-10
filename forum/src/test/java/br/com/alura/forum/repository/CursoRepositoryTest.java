package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
// tells spring to do not use a memory-base database
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// uses a test profile and application-test.properties
@ActiveProfiles("test")
class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;
    @Autowired
    private TestEntityManager em;

    @Test
    void shouldFindCourseByNome() {
        String nomeCurso = "HTML 5";

        Curso html5 = new Curso();
        html5.setNome("HTML 5");
        html5.setCategoria("Programacao");
        em.persist(html5);

        Curso curso = this.repository.findByNome(nomeCurso);
        Assert.assertNotNull(curso);
        Assert.assertEquals(nomeCurso, curso.getNome());
    }

    @Test
    void shouldNotFindCourseByNomeWhichIsNotStored() {
        String nomeCurso = "JPA";
        Curso curso = this.repository.findByNome(nomeCurso);
        Assert.assertNull(curso);
    }
}