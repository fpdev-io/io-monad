package io.fpdev


object IOMonadApp extends App {

  def getline() = IOMonad[String](scala.io.StdIn.readLine())
  def printline(s: String): IOMonad[Unit] = IOMonad[Unit](println(s))

  def result = for {
    _ <- printline("What's your name?")
    name <- getline
    _ <- printline(s"Hello, $name")
  } yield ()

  result.run
}
