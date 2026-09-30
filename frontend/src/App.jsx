import { useState } from 'react'
import './App.css'

// Cada operación apunta a su endpoint del back (el proxy de Vite reenvía /api al back)
const OPERACIONES = [
  { endpoint: 'sumar', etiqueta: 'Suma (+)' },
  { endpoint: 'restar', etiqueta: 'Resta (-)' },
  { endpoint: 'multiplicar', etiqueta: 'Multiplicación (*)' },
  { endpoint: 'dividir', etiqueta: 'División (/)' },
  { endpoint: 'raiz-cuadrada', etiqueta: 'Raíz cuadrada (√)' },
]

function App() {
  const [a, setA] = useState('')
  const [b, setB] = useState('')
  const [operacion, setOperacion] = useState(OPERACIONES[0].endpoint)
  const [resultado, setResultado] = useState(null)
  const [error, setError] = useState('')
  const [cargando, setCargando] = useState(false)

  const esUnaria = operacion === 'raiz-cuadrada'

  async function calcular(evento) {
    evento.preventDefault()
    setResultado(null)
    setError('')
    setCargando(true)

    try {
      const respuesta = await fetch(`/api/${operacion}`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          a: Number(a),
          b: esUnaria ? 0 : Number(b),
        }),
      })

      if (!respuesta.ok) {
        setError('No se pudo realizar la operación')
        return
      }

      setResultado(await respuesta.json())
    } catch {
      setError('No se pudo conectar con el servidor')
    } finally {
      setCargando(false)
    }
  }

  return (
    <main className="calculadora">
      <h1>Calculadora</h1>
      <form onSubmit={calcular}>
        <input
          type="number"
          step="any"
          placeholder={esUnaria ? 'Número' : 'Primer número'}
          value={a}
          onChange={(e) => setA(e.target.value)}
          required
        />
        <select value={operacion} onChange={(e) => setOperacion(e.target.value)}>
          {OPERACIONES.map((op) => (
            <option key={op.endpoint} value={op.endpoint}>
              {op.etiqueta}
            </option>
          ))}
        </select>
        {!esUnaria && (
          <input
            type="number"
            step="any"
            placeholder="Segundo número"
            value={b}
            onChange={(e) => setB(e.target.value)}
            required
          />
        )}
        <button type="submit" disabled={cargando}>
          {cargando ? 'Calculando...' : 'Calcular'}
        </button>
      </form>

      {resultado !== null && <p className="resultado">Resultado: {resultado}</p>}
      {error && <p className="error">{error}</p>}
    </main>
  )
}

export default App