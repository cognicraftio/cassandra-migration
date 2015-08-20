/**
 * Copyright 2010-2015 Axel Fontaine
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.contrastsecurity.cassandra.migration.utils.scanner.filesystem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileSystemResourceTest {
    @Test
    public void getFilename() throws Exception {
        assertEquals("Mig777__Test.sql", new FileSystemResource("Mig777__Test.sql").getFilename());
        assertEquals("Mig777__Test.sql", new FileSystemResource("folder/Mig777__Test.sql").getFilename());
    }

    @Test
    public void getPath() throws Exception {
        assertEquals("Mig777__Test.sql", new FileSystemResource("Mig777__Test.sql").getLocation());
        assertEquals("folder/Mig777__Test.sql", new FileSystemResource("folder/Mig777__Test.sql").getLocation());
    }
}
