package com.springer.drawing

import com.springer.drawing
import org.specs2.mutable.Specification

class CommandLineTest extends Specification {

  "extractor for line" >> {
    "wont 'extract' given invalid parameters" >> {
      CommandLine.command("") must beAnInstanceOf[DrawNothing]
      CommandLine.command("L one 2 3 4") must beAnInstanceOf[DrawNothing]
      CommandLine.command("L 1 two 3 4") must beAnInstanceOf[DrawNothing]
      CommandLine.command("L 1 2 three 4") must beAnInstanceOf[DrawNothing]
      CommandLine.command("L 1 2 3 four") must beAnInstanceOf[DrawNothing]
      CommandLine.command("x 1 2 3 4") must beAnInstanceOf[DrawNothing]
      CommandLine.command("L 1 2 3 4 extra") must beAnInstanceOf[DrawNothing]
    }
    "special case when the line that would be extract isn't actually valid (it's a diagonal for example" >> {
      CommandLine.command("L 1 1 2 2") must beAnInstanceOf[DrawNothing]
    }
    "extracts parameters" >> {
      CommandLine.command("L 2 1 2 3") must beAnInstanceOf[Line]
    }
  }

  "extractor for rectangles" >> {
    "wont 'extract' given invalid parameters" >> {
      CommandLine.command("") must beAnInstanceOf[DrawNothing]
      CommandLine.command("R one 2 3 4") must beAnInstanceOf[DrawNothing]
      CommandLine.command("R 1 two 3 4") must beAnInstanceOf[DrawNothing]
      CommandLine.command("R 1 2 three 4") must beAnInstanceOf[DrawNothing]
      CommandLine.command("R 1 2 3 four") must beAnInstanceOf[DrawNothing]
      CommandLine.command("x 1 2 3 4") must beAnInstanceOf[DrawNothing]
      CommandLine.command("R 1 2 3 4 extra") must beAnInstanceOf[DrawNothing]
    }
    "extracts parameters" >> {
      CommandLine.command("R 1 2 3 4") must_== Rectangle((1, 2), (3, 4))
    }
  }

  "extractor for fill" >> {
    "wont 'extract' given invalid parameters" >> {
      CommandLine.command("") must beAnInstanceOf[DrawNothing]
      CommandLine.command("B one 2 o") must beAnInstanceOf[DrawNothing]
      CommandLine.command("B 1 two o") must beAnInstanceOf[DrawNothing]
      CommandLine.command("B 1 2 colour") must beAnInstanceOf[DrawNothing]
      CommandLine.command("x 1 2 o") must beAnInstanceOf[DrawNothing]
      CommandLine.command("B 1 2 o extra") must beAnInstanceOf[DrawNothing]
    }
    "extracts parameters" >> {
      CommandLine.command("B 1 2 o") must beAnInstanceOf[Fill]
    }
  }

  "extractor for new canvas" >> {
    "wont 'extract' given invalid parameters" >> {
      CommandLine.command("") must beAnInstanceOf[DrawNothing]
      CommandLine.command("C  one  2") must beAnInstanceOf[DrawNothing]
      CommandLine.command("C 1 two") must beAnInstanceOf[DrawNothing]
      CommandLine.command("x 1 2") must beAnInstanceOf[DrawNothing]
      CommandLine.command("C 1 2 extra") must beAnInstanceOf[DrawNothing]
    }
    "extracts parameters" >> {
      CommandLine.command("C 1 2") must_== NewCanvas(1, 2)
    }
  }
}
