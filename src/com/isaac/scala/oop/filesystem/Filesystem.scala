package com.isaac.scala.oop.filesystem

import com.isaac.scala.oop.commands.Command
import com.isaac.scala.oop.files.Directory

object Filesystem extends App{

  val root = Directory.ROOT

  io.Source.stdin.getLines().foldLeft(State(root, root))((currentState, newLine) => {
    currentState.show
    Command.from(newLine).apply(currentState)
  })
}
