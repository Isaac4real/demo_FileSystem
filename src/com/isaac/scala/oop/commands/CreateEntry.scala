package com.isaac.scala.oop.commands
import com.isaac.scala.oop.files.{DirEntry, Directory}
import com.isaac.scala.oop.filesystem.State

abstract class CreateEntry(name: String) extends Command {

  def checkIllegal(name: String): Boolean = {
    name.contains(".")
  }

  def doCreateEntry(state: State): State = {
    def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry): Directory = {
      if (path.isEmpty) currentDirectory.addEntry(newEntry)
      else {
        val oldEntry = currentDirectory.findEntry(path.head).asDirectory
        currentDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry, path.tail, newEntry))
      }
    }

    val wd = state.wd
    val newEntry: DirEntry = createSpecificEntry(state)
    val allDirsInPath = wd.getAllFoldersInPath
    val newRoot = updateStructure(state.root, allDirsInPath, newEntry)
    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWd)
  }

  def createSpecificEntry(state: State): DirEntry

  override def apply(state: State): State = {
    val wd = state.wd
    if(wd.hasEntry(name)){
      state.setMessage(s"Entry $name already exists!")
    } else if(name.contains(Directory.SEPARATOR)){
      state.setMessage(name + "must not contian separators!")
    } else if(checkIllegal(name)) {
      state.setMessage(name + ": illegal entry name")
    } else {
      doCreateEntry(state)
    }

  }

}
