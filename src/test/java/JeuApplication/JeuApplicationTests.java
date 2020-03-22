package JeuApplication;

import JeuApplication.entity.*;
import JeuApplication.service.NoteService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JeuApplicationTests {
	private Jeu jeu;

	public JeuApplicationTests() {
		jeu = new Jeu();
		jeu.setTheme(new Theme());
		jeu.setGenre(new Genre());
		jeu.setEditeur(new Editeur());
		jeu.setType(new Type());
		jeu.setNom_jeu("test");
		jeu.getTheme().setNom_theme("test");
		jeu.getGenre().setNom_genre("test");
		jeu.getEditeur().setNom_editeur("test");
		jeu.getType().setNom_type("test");
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testNoteService1ReviewDidier() {
		Note review = new Note();
		review.setNom_testeur("Didier Loyal");
		review.setNote(5);
		jeu.getTheme().setNom_theme("science-fiction");
		assert NoteService.getNote(jeu, review) == 6;
	}

	@Test
	public void testNoteService2ReviewDidierGaston() {
		Note review = new Note();
		review.setNom_testeur("Didier Loyal");
		review.setNote(5);
		Note review1 = new Note();
		review1.setNom_testeur("Gaston Portaleau");
		review1.setNote(5);
		jeu.getTheme().setNom_theme("science-fiction");
		jeu.getType().setNom_type("jeu de cartes");
		assert NoteService.getNote(jeu, review, review1) == 5;
	}

	@Test
	public void testNoteService3ReviewDidierGastonLiz() {
		Note review = new Note();
		review.setNom_testeur("Didier Loyal");
		review.setNote(5);
		Note review1 = new Note();
		review1.setNom_testeur("Gaston Portaleau");
		review1.setNote(5);
		Note review2 = new Note();
		review2.setNom_testeur("Liz Smallhead");
		review2.setNote(4);
		jeu.getTheme().setNom_theme("science-fiction");
		jeu.getType().setNom_type("jeu de cartes");
		jeu.getEditeur().setNom_editeur("édijeu");
		assert NoteService.getNote(jeu, review, review1, review2) == 4;
	}
}
