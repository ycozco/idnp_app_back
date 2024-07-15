from gtts import gTTS

# El texto que deseas convertir a audio
texto = (
    "Las meninas o La familia de Felipe IV se considera la obra maestra del pintor del Siglo de Oro español Diego Velázquez. "
    "Acabado en 1656, según Antonio Palomino, fecha unánimemente aceptada por la crítica, corresponde al último período estilístico del artista, el de plena madurez."
)

# Crear el objeto gTTS
tts = gTTS(text=texto, lang='es')

# Guardar el archivo de audio
tts.save("las_meninas.mp3")

print("Archivo de audio generado exitosamente como 'las_meninas.mp3'.")
