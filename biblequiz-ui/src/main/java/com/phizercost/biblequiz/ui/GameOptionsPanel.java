package com.phizercost.biblequiz.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.DocumentFilter;

import com.phizercost.biblequiz.model.Category;
import com.phizercost.biblequiz.model.Question;
import com.phizercost.biblequiz.model.Team;
import com.phizercost.biblequiz.utils.BibleQuizFont;
import com.phizercost.biblequiz.utils.BibleQuizUtils;
import com.phizercost.biblequiz.utils.ComponentInitializer;
import com.phizercost.biblequiz.utils.UppercaseDocumentFilter;


public class GameOptionsPanel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Team firstTeam;
	Team secondTeam;

	JPanel panel;
	JLabel label;
	JButton firstSet;
	JButton secondSet;
	JButton thirdSet;
	JButton fourthSet;
	JLabel firstTeamLabel;
	JLabel secondTeamLabel;
	JLabel firstTeamScoreLabel;
	JLabel secondTeamScoreLabel;

	ButtonHandler click;
	BibleQuizFont fonts;
	DocumentFilter filter;
	
	int level = -1;
	boolean secondTeamCategory = false;



	public GameOptionsPanel(Team firstTeam, Team secondTeam, int level) {
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.level = level;
		
		initializeComponent();

	}
	
	public GameOptionsPanel(Team firstTeam, Team secondTeam, int level, boolean secondTeamCategory) {
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.level = level;
		this.secondTeamCategory = secondTeamCategory;
		
		initializeComponent();

	}
	
	
	private void initializeComponent() {
		filter = new UppercaseDocumentFilter();
		fonts = new BibleQuizFont();
		click = new ButtonHandler();
		ComponentInitializer componentInitializer;

		// Panel initialization
		panel = new JPanel();
		panel.setLayout(null);

		// Buttons Initialization
		componentInitializer = new ComponentInitializer("button", 625, 200, 250, 120);
		firstSet = componentInitializer.getButton();
		firstSet.setFont(fonts.getBtnFont());
		firstSet.addActionListener(click);

		componentInitializer = new ComponentInitializer("button", 625, 350, 250, 120);
		secondSet = componentInitializer.getButton();
		secondSet.setFont(fonts.getBtnFont());
		secondSet.addActionListener(click);

		componentInitializer = new ComponentInitializer("button", 625, 400, 250, 80);
		thirdSet = componentInitializer.getButton();
		thirdSet.setFont(fonts.getBtnFont());
		thirdSet.addActionListener(click);

		componentInitializer = new ComponentInitializer("button", 625, 500, 250, 120);
		fourthSet = componentInitializer.getButton();
		fourthSet.setFont(fonts.getBtnFont());
		fourthSet.addActionListener(click);

		firstSet.setText(BibleQuizUtils.QUICK_QUESTIONS_TITLE.getString());
		secondSet.setText(BibleQuizUtils.CATEGORY_QUESTIONS_TITLE.getString());
		thirdSet.setText(BibleQuizUtils.HINT_QUESTIONS_TITLE.getString());
		fourthSet.setText(BibleQuizUtils.BONUS_QUESTIONS_TITLE.getString());

		firstSet.setEnabled(false);
		secondSet.setEnabled(false);
		thirdSet.setEnabled(false);
		fourthSet.setEnabled(false);

		if (level == 1)
			firstSet.setEnabled(true);
		else if (level == 2)
			secondSet.setEnabled(true);
		else if (level == 3)
			thirdSet.setEnabled(true);
		else if (level == 4)
			fourthSet.setEnabled(true);
		// label initialization
		componentInitializer = new ComponentInitializer("label", 100, 15, 1200, 75);
		label = componentInitializer.getLabel();
		label.setText(BibleQuizUtils.MAIN_TITLE.getString());
		label.setFont(fonts.getMainlblFont());
		label.setHorizontalAlignment(0);

		// Team Labels initialization
		componentInitializer = new ComponentInitializer("label", 200, 100, 500, 150);
		firstTeamLabel = componentInitializer.getLabel();
		firstTeamLabel.setFont(fonts.getLblFont());
		firstTeamLabel.setText(firstTeam.getTeamName());

		componentInitializer = new ComponentInitializer("label", 1100, 100, 500, 150);
		secondTeamLabel = componentInitializer.getLabel();
		secondTeamLabel.setFont(fonts.getLblFont());
		secondTeamLabel.setText(secondTeam.getTeamName());

		// Team Scores Initialization

		componentInitializer = new ComponentInitializer("label", 225, 100, 300, 500);
		firstTeamScoreLabel = componentInitializer.getLabel();
		firstTeamScoreLabel.setFont(fonts.getScoreAndTeamLblFont());
		firstTeamScoreLabel.setText(Integer.toString(firstTeam.getTeamScore()));

		componentInitializer = new ComponentInitializer("label", 1125, 100, 300, 500);
		secondTeamScoreLabel = componentInitializer.getLabel();
		secondTeamScoreLabel.setFont(fonts.getScoreAndTeamLblFont());
		secondTeamScoreLabel.setText(Integer.toString(secondTeam.getTeamScore()));

		if (firstTeam.getTeamScore() < secondTeam.getTeamScore()) {
			firstTeamScoreLabel.setForeground(Color.RED);
			secondTeamScoreLabel.setForeground(Color.BLUE);
		} else if (firstTeam.getTeamScore() > secondTeam.getTeamScore()) {
			firstTeamScoreLabel.setForeground(Color.BLUE);
			secondTeamScoreLabel.setForeground(Color.RED);
		}
		// Adding components on the panel
		panel.add(firstSet);
		panel.add(secondSet);
		panel.add(thirdSet);
		panel.add(fourthSet);
		panel.add(label);
		panel.add(firstTeamLabel);
		panel.add(secondTeamLabel);
		panel.add(firstTeamScoreLabel);
		panel.add(secondTeamScoreLabel);
		
	}




	private class ButtonHandler implements ActionListener {
		// handle button event
		public void actionPerformed(ActionEvent event) {
			Component component = (Component) event.getSource();
			Category category;
			ArrayList<Category> categoryList = new ArrayList<Category>();
			ArrayList<Question> questionList =new ArrayList<Question>();
			Question question;
			if (event.getSource() == firstSet) {
				
				//To Be remove when we get the questions from the DB
				//=====================================================================================
				question = new Question(1, "Ni mu wuhe murwa Yosuwa yahagarikiyemo izuba?", "Gibeyoni", 10, 1, 30,
						0);
				questionList.add(question);
				question = new Question(2, "Ni uwuhe mwami wemereye Nehemiya Gusubira I Yerusalemu", "Aritazeruzi", 10, 1, 30, 0);
				questionList.add(question);
				question = new Question(3, "Ni nde wari umutambyi mukuru igihe Yesu yabambwaga?", "Kayafa", 10, 1, 30, 0);
				questionList.add(question);
				question = new Question(4, "Mu bantu babiri bazamutse mu rusengero gusenga.Harimo umufarisayo na nde?", "Umukoresha wikoro", 10, 1, 30, 0);
				questionList.add(question);
				question = new Question(5, "Ni nde wishe Sisera agakura abisirayeli mu maboko y'ingabo z'umwami Yabini?", "Yayeri", 10, 1, 30, 0);
				questionList.add(question);
				questionList.lastIndexOf(question);
				category = new Category(1,"Speed", questionList);
				//======================================================================================

				SpeedPanel speedPanel = new SpeedPanel(firstTeam, secondTeam, category);
				speedPanel.getPanel();
				swapPanel(speedPanel.getPanel(), component);
			} else if (event.getSource() == secondSet) {
				
				//To Be remove when we get the questions from the DB
				//=====================================================================================
				questionList =new ArrayList<Question>();
				question = new Question(1, "Yari umwami n'umugabo wa Yezebeli. Yitwaga nde?", "Ahabu", 10, 1, 30, 0);
				questionList.add(question);
				question = new Question(2, "Umwami wi Salemu, wahaye Aburahamu imitsima na wino yitwaga nde?", "Melikisedeki", 10, 1, 30, 0);
				questionList.add(question);
				question = new Question(3, "Se wa Yonatani, Umwami wa Isirayeli yitwaga nde?", "Sawuli", 10, 1, 30, 0);
				questionList.add(question);
				question = new Question(4, "Nuwuhe mwami waba Medi washyize Daniyeli mu rwobo rw'intare?", "Dariyo", 10, 1, 30, 0);
				questionList.add(question);
				question = new Question(5, "Nuwuhe mwami wi Tiro wafashije Salomo kubaka urusengero?", "Hiramu", 10, 1, 30, 0);
				questionList.add(question);
				
				category = new Category(1, "Abami muri Bibiliya", questionList);
				categoryList.add(category);
				
				questionList =new ArrayList<Question>();
				question = new Question(6, "Nikuwuhe munsi Imana yaremye amazi", "Kuwa 2", 10, 1, 30, 0);
				questionList.add(question);
				question = new Question(7, "Niyihe zaburi irimo interuro:'Antwara iruhande rw'amazi adasuma?", "23", 10, 1, 30, 0);
				questionList.add(question);
				question = new Question(8, "Ninde wahaye amazi ingamiya z'umugaragu wa Aburahamu?", "Rebeka", 10, 1, 30, 0);
				questionList.add(question);
				question = new Question(9, "Yesu asangira nabigishwa, yakoresheje iki amazi", "Yogeje Ibirenge", 10, 1, 30, 0);
				questionList.add(question);
				question = new Question(10, "Imvura yo ku mwuzure wo kwa Nowa yaguye igihe kingana iki?", "Iminsi 40 Amajoro 40", 10, 1, 30, 0);
				questionList.add(question);
				
				
				category = new Category(2, "Amazi muri Bibiliya", questionList);
				categoryList.add(category);
				
				questionList =new ArrayList<Question>();
				question = new Question(11, "Vuga irindi zina rya Tomasi wawundi washidikanyije ko Yesu yazutse?", "Didumo", 10, 1, 30, 0);
				questionList.add(question);
				question = new Question(12, "Vuga amazina y'intumwa eshatu zajyanye na Yesu ku musozi wo Guhindurirwaho?", "Yohana, Petero, Yakobo", 10, 1, 30, 0);
				questionList.add(question);
				question = new Question(13, "Yesu yohereje intumwa ze ebyiri ebyiri abasaba ko batwara inkweto zonyine niki kindi?", "Inkoni", 10, 1, 30, 0);
				questionList.add(question);
				question = new Question(14, "Umwigishwa wazaniye Yesu umwana warufite imitsima itanu n'amafi abiri yitwaga nde?", "Andereya", 10, 1, 30, 0);
				questionList.add(question);
				question = new Question(15, "Ni uwuhe mwigishwa wasabye Yesu kubereka Data?", "Filipo", 10, 1, 30, 0);
				questionList.add(question);
				
				category = new Category(3, "Abigishwa ba Yesu", questionList);
				categoryList.add(category);
				
				//=====================================================================================
				
				CategoryPanel categoryPanel = new CategoryPanel(firstTeam, secondTeam, categoryList, secondTeamCategory);
				categoryPanel.getPanel();
				swapPanel(categoryPanel.getPanel(), component);
			} else if (event.getSource() == thirdSet) {
				
				//To Be remove when we get the questions from the DB
				//=====================================================================================
				
				questionList =new ArrayList<Question>();
				
				ArrayList<String> questionDetails = new ArrayList<String>();
				questionDetails.add("Utungiwe  agatoki ");
				questionDetails.add("Inyanja ya Nile");
				questionDetails.add("umukobwa wa Falawo");
				questionDetails.add("Agaseke");
				
				question = new Question(1, "", "Mose", 40, 1, 20, 0, questionDetails);
				questionList.add(question);
				
				questionDetails = new ArrayList<String>();
				questionDetails.add("Ifarashi ");
				questionDetails.add("umuvumo");
				questionDetails.add("Malayika");
				questionDetails.add("Umuhanuzi w'Ikinyoma");
				question = new Question(2, "", "Balamu", 40, 1, 20, 0, questionDetails);
				questionList.add(question);
				
				
				//=================================================================================================
				HintsPanel hintPanel = new HintsPanel(firstTeam, secondTeam, questionList);
				hintPanel.getPanel();
				swapPanel(hintPanel.getPanel(), component);
			} else if (event.getSource() == fourthSet) {
				
				
				//To Be remove when we get the questions from the DB
				//=====================================================================================
				question = new Question(1, "Ni nde Imana yabwiye ngo abantu bareba ubwiza bugaragara Uwiteka areba mu mutima?", "Samweli", 100, 1, 30,
						0);
				questionList.add(question);
				question = new Question(2, "Ahantu Yakobo yakiraniye n'Imana yahise irihe zina?", "Penuweli", 100, 1, 30, 0);
				questionList.add(question);
				questionList.lastIndexOf(question);
				category = new Category(1,"Speed", questionList);
				//======================================================================================

				SpeedPanel speedPanel = new SpeedPanel(firstTeam, secondTeam, category);
				speedPanel.getPanel();
				swapPanel(speedPanel.getPanel(), component);
			}
		}

		private void swapPanel(JPanel panel, Component component) {

			JFrame frame = (JFrame) SwingUtilities.getRoot(component);
			frame.getContentPane().removeAll();
			frame.setContentPane(panel);
			frame.setResizable(false);
			frame.setVisible(true);

		}
	}

	public JPanel getPanel() {
		return panel;
	}

}
