package ru.astral.test.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.astral.test.addressbook.model.ContactData;

import java.io.File;
import java.util.List;

/**
 * Created by Fedor on 08.11.2016.
 */
public class ContactDataGenerator {
  @Parameter(names = {"--count", "-c"}, description = "Contact count")
  public int count;
  @Parameter(names = {"--filename", "-f"}, description = "Target filename")
  public String filename;
  @Parameter(names = {"--format", "-d"}, description = "Target file format")
  public String format;

  public void main(String[] args){
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() {
    List<ContactData> contacts =  generate(count);
    if (format.equals("csv")){
      saveCsv(contacts,new File(filename));
    } else if (format.equals("xml")) {
      saveXml(contacts,new File(filename));
    } else if (format.equals("json")){
      saveJson(contacts,new File(filename));
    }else {
      System.out.println("Unrecognized format " + format);
    }
  }

  private void saveJson(List<ContactData> contacts, File file) {

  }

  private void saveXml(List<ContactData> contacts, File file) {

  }

  private void saveCsv(List<ContactData> contacts, File file) {

  }

  private List<ContactData> generate(int count) {
    return null;
  }
}
