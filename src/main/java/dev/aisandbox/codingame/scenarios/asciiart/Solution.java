package dev.aisandbox.codingame.scenarios.asciiart;

import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {

  Scanner input;
  Map<Character, List<String>> font = new HashMap<>();
  String message = "";
  int H;

  public Solution(Scanner in) {
    input = in;
  }

  public void readFont() {
    int L = input.nextInt();
    System.err.println("L = " + L);
    H = input.nextInt();
    input.nextLine();
    System.err.println("H = " + H);
    message = input.nextLine();
    System.err.println("Message = " + message);
    // now read the font
    for (int i = 0; i < H; i++) {
      String ROW = input.nextLine();
      System.err.println(i + ">" + ROW);
      for (int x = 0; x < 27; x++) {
        String el = ROW.substring(x * L, (x + 1) * L);
        char c = (char) ('A' + x);
        if (i == 0) {
          List<String> els = new ArrayList<>();
          els.add(el);
          font.put(c, els);
        } else {
          font.get(c).add(el);
        }
      }
    }
  }

  public void write() {
    System.err.println("Defined font for " + font.keySet().toString());
    // optimise the message so it scans
    message = message.toUpperCase().replaceAll("[^A-Z]", "[");
    System.err.println("New Message = " + message);

    for (int y = 0; y < H; y++) {
      for (int x = 0; x < message.length(); x++) {
        char c = message.charAt(x);
        System.out.print(font.get(c).get(y));
      }
      System.out.println();
    }
  }

  public static void main(String args[]) {
    Solution solution = new Solution(new Scanner(System.in));
    solution.readFont();
    solution.write();
  }
}
