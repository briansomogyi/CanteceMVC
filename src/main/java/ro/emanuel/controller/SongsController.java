package ro.emanuel.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.emanuel.cantece.dao.CantecDAO;
import ro.emanuel.cantece.pojo.Cantec;

@Controller
public class SongsController {

	@GetMapping("/song")
	public String singleSong(@RequestParam(name = "id", required = true, defaultValue = "1") int id, Model model)
			throws SQLException, ClassNotFoundException {
		// Iau obiectul din baza de date
		Cantec cantec = CantecDAO.getById(id);

		// Adaug cantecul in pagina jsp
		model.addAttribute("song", cantec);

		return "song.jsp";
	}

	@GetMapping("/songs")
	public String allSongs(Model model) throws SQLException, ClassNotFoundException {
		// Iau obiectele din baza de date
		List<Cantec> cantece = CantecDAO.getAll();

		// Adaug cantecele in pagina jsp
		model.addAttribute("songs", cantece);

		return "songs.jsp";
	}

	@GetMapping("songs/edit/{id}")
	public String editSong(Model model, @PathVariable int id) throws ClassNotFoundException, SQLException {
		// Iau obiectul din baza de date
		Cantec cantec = CantecDAO.getById(id);

		// Adaug cantecul in pagina jsp
		model.addAttribute("song", cantec);

		return "/songEdit.jsp";
	}

	@PostMapping("songs/edit")
	public String saveSong(@ModelAttribute("song") Cantec cantec, Model model, BindingResult result)
			throws ClassNotFoundException, SQLException {
		CantecDAO.update(cantec);

		return "redirect:/songs";
	}

	@GetMapping("/songs/createSong")
	public String createSong(Model model) {
		Cantec cantec = new Cantec();
		model.addAttribute("newSong", cantec);
		return "/createSong.jsp";
	}

	@PostMapping("/songs/saveNewSong")
	public String saveNewSong(@ModelAttribute("newSong") Cantec cantec) throws ClassNotFoundException, SQLException {
		CantecDAO.create(cantec);
		return "redirect:/songs";
	}

	@GetMapping("/song/delete/{id}")
	public String deleteSong(@PathVariable int id) throws ClassNotFoundException, SQLException {
		CantecDAO.delete(id);
		return "redirect:/songs";
	}

}
