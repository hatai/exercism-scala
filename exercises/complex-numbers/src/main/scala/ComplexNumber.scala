case class ComplexNumber(real: Double = 0.0, imaginary: Double = 0.0) {
  override def equals(obj: Any): Boolean = super.equals(obj)

  def +(obj: ComplexNumber): ComplexNumber = {
    ComplexNumber(this.real + obj.real, this.imaginary + obj.imaginary)
  }

  def -(obj: ComplexNumber): ComplexNumber = {
    ComplexNumber(this.real - obj.real, this.imaginary - obj.imaginary)
  }

  def *(obj: ComplexNumber): ComplexNumber = ComplexNumber(
    this.real * obj.real - this.imaginary * obj.imaginary,
    this.imaginary * obj.real + this.real * obj.imaginary
  )

  def /(obj: ComplexNumber): ComplexNumber = ComplexNumber(
    (this.real * obj.real + this.imaginary * obj.imaginary) / (Math.pow(obj.real, 2) + Math.pow(obj.imaginary, 2)),
    (obj.real * this.imaginary - this.real * obj.imaginary) / (Math.pow(obj.real, 2) + Math.pow(obj.imaginary, 2))
  )

  def abs: Double = Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2))

  def conjugate: ComplexNumber = ComplexNumber(this.real, -this.imaginary)
}


object ComplexNumber {
  def exp(obj: ComplexNumber): ComplexNumber = ComplexNumber(
    Math.exp(obj.real) * Math.cos(obj.imaginary), Math.sin(obj.imaginary)
  )
}
