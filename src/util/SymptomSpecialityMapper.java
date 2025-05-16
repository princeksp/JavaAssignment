package util;

import java.util.Map;

public class SymptomSpecialityMapper {
  public static final Map<String, String> symptomToSpeciality = Map.of(
      "Arthritis", "Orthopaedic",
      "Back Pain", "Orthopaedic",
      "Tissue injuries", "Orthopaedic",
      "Dysmenorrhea", "Gynecology",
      "Skin infection", "Dermatology",
      "Skin burn", "Dermatology",
      "Ear pain", "ENT");
}