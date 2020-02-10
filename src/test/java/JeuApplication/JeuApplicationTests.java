package JeuApplication;

import JeuApplication.entity.*;
import JeuApplication.service.NoteService;
import JeuApplication.service.Review;
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
		Review review = new Review("Didier Loyal", 5);
		jeu.getTheme().setNom_theme("science-fiction");
		assert NoteService.getNote(jeu, review) == 6;
	}

	@Test
	public void testNoteService2ReviewDidierGaston() {
		Review review = new Review("Didier Loyal", 5);
		Review review1 = new Review("Gaston Portaleau", 5);
		jeu.getTheme().setNom_theme("science-fiction");
		jeu.getType().setNom_type("jeu de cartes");
		assert NoteService.getNote(jeu, review, review1) == 5;
	}

	@Test
	public void testNoteService3ReviewDidierGastonLiz() {
		Review review = new Review("Didier Loyal", 5);
		Review review1 = new Review("Gaston Portaleau", 5);
		Review review2 = new Review("Liz Smallhead", 4);
		jeu.getTheme().setNom_theme("science-fiction");
		jeu.getType().setNom_type("jeu de cartes");
		jeu.getEditeur().setNom_editeur("édijeu");
		assert NoteService.getNote(jeu, review, review1, review2) == 4;
	}
}
