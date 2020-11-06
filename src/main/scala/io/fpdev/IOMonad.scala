package io.fpdev

class IOMonad[A] private (code: => A) {

  def run = code

  def map[B](f: A => B): IOMonad[B] = flatMap(a => IOMonad(f(a)))

  def flatMap[B](f: A => IOMonad[B]): IOMonad[B] = IOMonad(f(code).run)
}

object IOMonad {
  def apply[A](code: => A): IOMonad[A] = new IOMonad(code)
}