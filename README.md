# Single-Rotor-Encoder-Decoder
Personal Project in Java to familiarize with app development.

Encoder/Decrypter simulates single rotor function. (Also supports punctuation)

Plaintext is input to a mapping table (similar to a static wheel in an Enigma machine)
The mapping table is then connected to a character string, mimicking the rotor/scrambler to produce ciphertext
Each character in the plaintext is encrypted by a different character in the rotor string.
This permits the same input character to be encoded to different output characters (polyalphabetic cipher)

The first line in the UI takes either the plaintext or the ciphertext as input (for encoding or decoding, respectively)
The second line in the UI takes the starting position of the rotor. Different starting positions correspond to different ciphertexts.
