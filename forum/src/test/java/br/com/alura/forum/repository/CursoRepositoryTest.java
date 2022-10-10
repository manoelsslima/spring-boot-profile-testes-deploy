package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;

    @Test
    void shouldFindCourseByNome() {
        String nomeCurso = "HTML 5";
        Curso curso = this.repository.findByNome(nomeCurso);
        Assert.assertNotNull(curso);
        Assert.assertEquals(nomeCurso, curso.getNome());
    }

    @Test
    void shouldNotFindCourseByNomeWhichIsNotStored() {
        String nomeCurso = "JPA";
        Curso curso = this.repository.findByNome("HTML 5");
        Assert.assertNotEquals(nomeCurso, curso.getNome());
    }
}