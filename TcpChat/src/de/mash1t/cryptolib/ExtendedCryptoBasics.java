/*
 * The MIT License
 *
 * Copyright 2015 Manuel Schmid.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.mash1t.cryptolib;

import static de.mash1t.cryptolib.Method.Caesar;
import de.mash1t.cryptolib.method.*;

/**
 * Contains all basic information for session and cryptography
 *
 * @author Manuel Schmid
 */
@SuppressWarnings("FieldNameHidesFieldInSuperclass")
public class ExtendedCryptoBasics extends CryptoBasics {

    /**
     * Encryption in bytes,
     */

    public static final int encryptionBytes = 16;

    /**
     * Bits to make SessionId from
     */
    public static final int encryptionBits = (encryptionBytes * 8);

    /**
     * Currently used encryptionBytes method
     */
    public static Method encMethod = Method.ExtendedAES;

    /**
     * Makes an encryption object of type encMethod
     *
     * @return EncryptionMethod
     */
    public static EncryptionMethod makeEncryptionObject() {
        switch (encMethod) {
            case AES:
                return new Aes();
            case ExtendedAES:
                return new ExtendedAes();
            case Caesar:
                return new Caesar(offset);
            case Vignere:
                return new Vignere(key);
            default:
                return new EncryptionMethod();
        }
    }
}
