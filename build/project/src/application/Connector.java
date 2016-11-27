package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Connector {

  public Connector(SQLiteJDBC DB, UserInterface UI) {
    handleButAdaugare(DB, UI);
    handleButInterogare(DB, UI);
  }

  private void handleButInterogare(SQLiteJDBC dB, UserInterface uI) {
    uI.butInterogare.setOnMouseEntered(value -> {
      uI.statusbar.setText("Apasa pentru a interoga baza de date");
    });

    uI.butInterogare.setOnMouseExited(value -> {
      uI.statusbar.setText("OK");
    });

    uI.butInterogare.setOnAction(value -> {
      uI.statusbar.setText("Se interogheaza baza de date");
      try {
        uI.QoutputWindow.setText("Rezultate:");
        ResultSet cnt = dB.getCount(uI.QcodBoala.getText(), CategoriiVarsta.getIndex(uI.Qvarsta.getValue()), uI.Qsexul.getValue());
        if (cnt != null) {
          if (cnt.next()) {
            uI.QoutputWindow.appendText(" " + cnt.getInt(1) + "\n\n");
          }
        }
        cnt.close();

        ResultSet rs = dB.getQuery(uI.QcodBoala.getText(), CategoriiVarsta.getIndex(uI.Qvarsta.getValue()), uI.Qsexul.getValue());
        if (rs != null) {
          while (rs.next()) {
            int nrCrt = rs.getInt("NRCRT");
            int codBoala = rs.getInt("COD_BOALA");
            int catVarsta = rs.getInt("CATEGORIE_VARSTA");
            String sexul = rs.getString("SEX");
            System.out.println("NRCRT            = " + nrCrt);
            System.out.println("COD_BOALA        = " + codBoala);
            System.out.println("CATEGORIE_VARSTA = " + catVarsta);
            System.out.println("GENUL            = " + sexul);
            System.out.println();

            // DO not touch this!
            uI.QoutputWindow.appendText("INREG                          = " + nrCrt + "\n");
            uI.QoutputWindow.appendText("COD_BOALA                = " + codBoala + "\n");
            uI.QoutputWindow.appendText("CATEGORIE_VARSTA = " + CategoriiVarsta.categoriiVarsta[catVarsta - 1] + "\n");
            uI.QoutputWindow.appendText("GENUL                         = " + sexul + "\n");
            uI.QoutputWindow.appendText("\n");

          }
          rs.close();
        }

      } catch (NumberFormatException | InvalidArgumentException e) {
        e.printStackTrace();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });
  }

  private void handleButAdaugare(SQLiteJDBC DB, UserInterface UI) {
    UI.butAdaugare.setOnMouseEntered(value -> {
      UI.statusbar.setText("Apasa pentru adaugare in baza de date");
    });

    UI.butAdaugare.setOnMouseExited(value -> {
      UI.statusbar.setText("OK");
    });

    UI.butAdaugare.setOnAction(value -> {
      UI.statusbar.setText("Se adauga in baza de date");
      // TODO make varsta map to a value from the categorii de varsta
      // TODO clear the textboxes after insert
      // TODO create an overview stringbox in the UI itself
      try {
        if (DB.newEntry(Integer.parseInt(UI.codBoala.getText()), getAgeCategory(Integer.parseInt(UI.varsta.getText())),
            UI.sexul.getValue().charAt(0))) {
          UI.outputWindow.clear();
          DB.printContent();
          UI.statusbar.setText("Adaugat!");
          UI.outputWindow.appendText("COD_BOALA                = " + UI.codBoala.getText() + "\n");
          UI.outputWindow.appendText("CATEGORIE_VARSTA = " + getAgeCategory(Integer.parseInt(UI.varsta.getText())) + "\n");
          UI.outputWindow.appendText("GENUL                         = " + UI.sexul.getValue().charAt(0) + "\n");
          UI.outputWindow.appendText("\n");
          UI.codBoala.clear();
          UI.varsta.clear();
          
        }
      } catch (NumberFormatException | InvalidArgumentException e) {
        e.printStackTrace();
      }
    });
  }

  public static int getAgeCategory(int Age) {
    if (Age >= 85) {
      return 18;
    }
    int cat = 1;
    for (int i = 0; i < 86; i += 5, cat++) {
      if (i > Age)
        return cat - 1;
    }
    return 0;
  }
}
