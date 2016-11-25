repl.prompt() = ">"
repl.colors().prompt() = fansi.Color.Green

@
import ammonite.ops._

import generic.shapes._
import generic.json._
import generic.json.derivative.DerivativeEncoders._
import generic.json.simple.SimpleEncoders._
import generic.show.Show
import generic.show.Show._

val sources = pwd/'src/'main/'scala/'generic