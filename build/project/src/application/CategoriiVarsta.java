package application;

public class CategoriiVarsta {
  public static String[] categoriiVarsta = { "0-4", "5-9", "10-14", "15-19", "20-24", "25-29", "30-34", "35-39",
      "40-44", "45-49", "50-54", "55-59", "60-64", "65-69", "70-74", "75-79", "80-84", "85+" };

  public static String getIndex(String varsta) {
    for (int i = 0; i < categoriiVarsta.length; i++) {
      if (categoriiVarsta[i].equalsIgnoreCase(varsta)) {
        return String.valueOf(i + 1);
      }
    }
    return null;
  }
}
