/*
 * Copyright 2018-present MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mongodb.stitch.server.core.services;

import java.util.List;
import org.bson.codecs.Codec;

public interface StitchService {
  /**
   * Calls the specified Stitch service function, and decodes the response into an instance of the
   * specified type. The response will be decoded using the codec registry specified when the app
   * client was configured. If no codec registry was configured, a default codec registry will be
   * used. The default codec registry supports the mappings specified <a
   * href="http://mongodb.github.io/mongo-java-driver/3.1/bson/documents/#document">here</a>
   *
   * @param name The name of the Stitch service function to call.
   * @param args The arguments to pass to the function.
   * @param resultClass The class that the response should be decoded as.
   * @param <ResultT> The type into which the response will be decoded.
   * @return The decoded value.
   */
  <ResultT> ResultT callFunction(
      final String name, final List<? extends Object> args, final Class<ResultT> resultClass);

  /**
   * Calls the specified Stitch service function, and decodes the response into a value using the
   * provided {@link Codec}.
   *
   * @param name The name of the Stitch service function to call.
   * @param args The arguments to pass to the function.
   * @param resultCodec The {@link Codec} to use to decode the response into a value.
   * @param <ResultT> The type into which the response will be decoded.
   * @return The decoded value.
   */
  <ResultT> ResultT callFunction(
      final String name, final List<? extends Object> args, final Codec<ResultT> resultCodec);
}